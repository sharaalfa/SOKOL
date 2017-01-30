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

import io.khasang.sokol.dao.RoleDao;
import io.khasang.sokol.entity.Role;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl extends GenericDaoImpl<Role, Integer> implements RoleDao {
    public RoleDaoImpl() {
        super(Role.class);
    }

    @Override
    public Role getByName(String name) {
        return (Role) getSession().createCriteria(Role.class)
                .add(Restrictions.eq("name", name)).uniqueResult();
    }

    @Override
    public List<Role> getForRegisterForm() {
        return (List<Role>) getSession().createCriteria(Role.class)
                .add(Restrictions.ne("name", "ROLE_ADMIN")).list();
    }
}
