/*
 * Copyright 2016-2017 Sokol Development Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.khasang.sokol.dao.impl;

import io.khasang.sokol.dao.RequestDao;
import io.khasang.sokol.dao.RequestStatusDao;
import io.khasang.sokol.dao.UserDao;
import io.khasang.sokol.entity.MyPanelScore;
import io.khasang.sokol.entity.Request;
import io.khasang.sokol.entity.RequestStatus;
import io.khasang.sokol.entity.User;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public class RequestDaoImpl extends GenericDaoImpl<Request, Integer> implements RequestDao {
    @Autowired
    UserDao userDao;
    @Autowired
    RequestStatusDao requestStatusDao;

    public RequestDaoImpl() {
        super(Request.class);
    }

    @Override
    public Request getByRequestId(Integer requestId) {
        return getSession().get(Request.class, requestId);
    }

    @Override
    public MyPanelScore getScoreIn(String userName)
    {
        MyPanelScore score  = new MyPanelScore();
        List<Object[]> scoreQuery = getSession().createSQLQuery("select sum(CASE WHEN request_status_id = 1 THEN 1 ELSE 0 END) SCORE_NEW,\n" +
                "  sum(CASE WHEN request_status_id = 2 THEN 1 ELSE 0 END) SCORE_INPROGRESS,\n" +
                "  sum(CASE WHEN request_status_id = 3 THEN 1 ELSE 0 END) SCORE_DONE\n" +
                "from requests where created_by = :p_created_by").setParameter("p_created_by", userName ).list();
        if(scoreQuery != null  && scoreQuery.size() > 0){

            score.setCountNew(((BigInteger)scoreQuery.get(0)[0]).intValue());
            score.setCountInProgress(((BigInteger)scoreQuery.get(0)[1]).intValue());
            score.setCountClosed(((BigInteger)scoreQuery.get(0)[2]).intValue());
        }
        return  score;

    }
    @Override
    public MyPanelScore getScoreOut(String userName)
    {
        User user = userDao.getByLogin(userName);
        MyPanelScore score  = new MyPanelScore();
        List<Object[]> scoreQuery = getSession().createSQLQuery("select sum(CASE WHEN request_status_id = 1 THEN 1 ELSE 0 END) SCORE_NEW,\n" +
                "  sum(CASE WHEN request_status_id = 2 THEN 1 ELSE 0 END) SCORE_INPROGRESS,\n" +
                "  sum(CASE WHEN request_status_id = 3 THEN 1 ELSE 0 END) SCORE_DONE\n" +
                "from requests where assigned_to = :p_assigned_to").setParameter("p_assigned_to", user.getId() ).list();
        if(scoreQuery != null  && scoreQuery.size() > 0){
            score.setCountNew(((BigInteger)scoreQuery.get(0)[0]).intValue());
            score.setCountInProgress(((BigInteger)scoreQuery.get(0)[1]).intValue());
            score.setCountClosed(((BigInteger)scoreQuery.get(0)[2]).intValue());
        }
        return  score;

    }
    @Override
    public List<Request> getMyRequests(String userName) {
        User user = userDao.getByLogin(userName);
        RequestStatus statusClosed = requestStatusDao.getById(3);
        RequestStatus statusCanceled = requestStatusDao.getById(4);
        return (List<Request>) getSession().createCriteria(Request.class)
                .add(Restrictions.eq("assignedTo", user))
                .add(Restrictions.ne("status", statusClosed))
                .add(Restrictions.ne("status", statusCanceled))
                .list();
    }

    @Override
    public List<Request> getRequestsForMe(String userName) {
        RequestStatus statusClosed = requestStatusDao.getById(3);
        RequestStatus statusCanceled = requestStatusDao.getById(4);
        return (List<Request>) getSession().createCriteria(Request.class)
                .add(Restrictions.eq("createdBy", userName))
                .add(Restrictions.ne("status", statusClosed))
                .add(Restrictions.ne("status", statusCanceled))
                .list();
    }

    @Override
    public Request getByName(String name) {
        return (Request) getSession().createCriteria(Request.class)
                .add(Restrictions.eq("title", name))
                .uniqueResult();
    }

    @Override
    public Integer getCountLineOfTable() {
        Session session = getSession();
        String countQ = "Select count (f.requestId) from Request f";
        Query countQuery = session.createQuery(countQ);
        long countResults = (long) countQuery.uniqueResult();
        return (int) countResults;
    }
}
