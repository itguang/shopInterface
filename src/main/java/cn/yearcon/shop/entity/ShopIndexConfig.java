/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package cn.yearcon.shop.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 积分商城首页配置Entity
 *
 * @author itguang
 * @version 2017-10-19
 */
@Entity
public class ShopIndexConfig {

    /**
     * id
     */
    @Id
    private String id;
    /**
     * 图片地址
     */
    private String pictureUrl;
    /**
     * 链接地址
     */
    private String linkto;
    /**
     * 类型(1,图片轮播 / 2 首页菜单/ 3 首页导航)
     */
    private Integer type;
    /**
     * // 排序值
     */
    private Integer sort;
    /**
     * // 图片标题
     */
    private String name;
    /**
     * // 导航图标地址
     */
    private String iconUrl;
    /**
     * // 是否是icon(0否/1是.  默认为0)
     */
    private Integer isIcon;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getLinkto() {
        return linkto;
    }

    public void setLinkto(String linkto) {
        this.linkto = linkto;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Integer getIsIcon() {
        return isIcon;
    }

    public void setIsIcon(Integer isIcon) {
        this.isIcon = isIcon;
    }

    @Override
    public String toString() {
        return "ShopIndexConfig{" +
                "id='" + id + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", linkto='" + linkto + '\'' +
                ", type=" + type +
                ", sort=" + sort +
                ", name='" + name + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", isIcon=" + isIcon +
                '}';
    }
}