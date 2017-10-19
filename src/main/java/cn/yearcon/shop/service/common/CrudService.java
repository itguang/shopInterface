package cn.yearcon.shop.service.common;

import cn.yearcon.shop.mapper.common.CrudDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

public abstract class CrudService<D extends CrudDao<T>, T > {
    /**
     * 持久层对象
     */
    @Autowired
    protected D dao;

    /**
     * 获取单条数据
     * @param id
     * @return
     */
    public T get(String id) {
        return dao.get(id);
    }

    /**
     * 获取单条数据
     * @param entity
     * @return
     */
    public T get(T entity) {
        return dao.get(entity);
    }

    /**
     * 查询列表数据
     * @param entity
     * @return
     */
    public List<T> findList(T entity) {
        return dao.findList(entity);
    }

//    /**
//     * 查询分页数据
//     * @param page 分页对象
//     * @param entity
//     * @return
//     */
//    public Page<T> findPage(Page<T> page, T entity) {
//        entity.setPage(page);
//        page.setList(dao.findList(entity));
//        return page;
//    }

    /**
     * 保存数据（插入或更新）
     * @param entity
     */
    @Transactional(readOnly = false)
    public void save(T entity) {

            dao.insert(entity);

    }

    /**
     * 删除数据
     * @param entity
     */
    @Transactional(readOnly = false)
    public void delete(T entity) {
        dao.delete(entity);
    }



    /**
     * 删除全部数据
     * @param entitys
     */
    @Transactional(readOnly = false)
    public void deleteAll(Collection<T> entitys) {
        for (T entity : entitys) {
            dao.delete(entity);
        }
    }



    /**
     *获取单条数据
     * @param propertyName
     * @param value
     * @return
     */
    public T findUniqueByProperty(String propertyName, Object value){
        return dao.findUniqueByProperty(propertyName, value);
    }
}
