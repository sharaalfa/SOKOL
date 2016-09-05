//package dao;
//
//import io.khasang.sokol.dao.RequestDao;
//import io.khasang.sokol.entity.Request;
//import org.junit.Assert;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import static org.junit.Assert.*;
//
//public abstract class RequestDaoTest implements RequestDao{
//    @Autowired
//    RequestDao requestDao;
//
//
//    @Test
//    public void testGetByName() throws Exception {
//
//
//    }
//
//    @Test
//    public void testGetByRequestId() throws Exception {
//    Request request = requestDao.getByRequestId(Integer.valueOf("request_id"));
//        Assert.assertNotNull(request);
//    }
//}