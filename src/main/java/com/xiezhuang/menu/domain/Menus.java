package com.xiezhuang.menu.domain;/**
 * TODO
 *
 * @author 谢树树
 * @date 18/4/2021 下午7:32
 */
public class Menus {
   private Integer  m_id;
   private String m_name;
   private float m_price;
   private byte[] picture;
   private String remake;

   public Menus(byte[] picture) {
      this.picture = picture;
   }

   public Menus() {
   }

   public Integer getM_id() {
      return m_id;
   }

   public void setM_id(Integer m_id) {
      this.m_id = m_id;
   }

   public String getM_name() {
      return m_name;
   }

   public void setM_name(String m_name) {
      this.m_name = m_name;
   }

   public float getM_price() {
      return m_price;
   }

   public void setM_price(float m_price) {
      this.m_price = m_price;
   }

   public byte[] getPicture() {
      return picture;
   }

   public void setPicture(byte[] picture) {
      this.picture = picture;
   }

   public String getRemake() {
      return remake;
   }

   public void setRemake(String remake) {
      this.remake = remake;
   }

   public Menus(Integer m_id, String m_name, float m_price, byte[] picture, String remake) {
      this.m_id = m_id;
      this.m_name = m_name;
      this.m_price = m_price;
      this.picture = picture;
      this.remake = remake;
   }
}
