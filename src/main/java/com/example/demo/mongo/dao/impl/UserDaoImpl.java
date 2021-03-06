package com.example.demo.mongo.dao.impl;

import com.example.demo.mongo.dao.UserDao;
import com.example.demo.mongo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 创建对象
     *
     * @param user
     */
    @Override
    public void saveUser(User user) {
        mongoTemplate.save(user);
    }

    /**
     * 根据用户名查询对象
     *
     * @param userName
     * @return
     */
    @Override
    public User findUserByName(String userName) {
        //name为mongodb中的字段
        Query query = new Query(Criteria.where("name").is(userName));
        User user = mongoTemplate.findOne(query, User.class);
        return user;
    }


    /**
     * ss
     * 更新对象
     *
     * @param user
     */
    @Override
    public void updateUser(User user) {
        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update().set("name", user.getName()).set("age", user.getAge());
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query, update, User.class);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,UserEntity.class);
    }


    /**
     * 删除对象
     *
     * @param id
     */
    @Override
    public void deleteUserById(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, User.class);
    }

}
