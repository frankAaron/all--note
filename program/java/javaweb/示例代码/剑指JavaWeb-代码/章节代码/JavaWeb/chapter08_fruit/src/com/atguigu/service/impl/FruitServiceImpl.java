package com.atguigu.service.impl;

import com.atguigu.bean.Fruit;
import com.atguigu.dao.FruitDAO;
import com.atguigu.dao.impl.FruitDAOImpl;
import com.atguigu.service.FruitService;

import java.util.List;

public class FruitServiceImpl implements FruitService {

    private FruitDAO fruitDAO = new FruitDAOImpl();

    @Override
    public List<Fruit> getFruitList() {
        return fruitDAO.getFruitList();
    }

    @Override
    public Fruit getFruitByFid(Integer fid) {
        return fruitDAO.getFruitByFid(fid);
    }

   @Override
    public void updateFruit(Fruit fruit) {
        fruitDAO.updateFruit(fruit);
    }

    @Override
    public void delFruit(Integer fid) {
        fruitDAO.delFruit(fid);
    }

    @Override
    public void addFruit(Fruit fruit) {
        fruitDAO.addFruit(fruit);
    }
}
