package com.bsuir.entity;

import com.bsuir.entity.point.F;
import com.bsuir.entity.point.V;
import com.bsuir.entity.point.VN;
import com.bsuir.entity.point.VT;

import java.util.ArrayList;
import java.util.List;

public class Texture {

  private List<V> vList;
  private List<VT> vtList;
  private List<VN> vnList;
  private List<F> fList;

  public Texture(List<V> vList, List<VT> vtList, List<VN> vnList, List<F> fList) {
    this.vList = vList;
    this.vtList = vtList;
    this.vnList = vnList;
    this.fList = fList;
  }

  public List<V> getvList() {
    return vList;
  }

  public void setvList(List<V> vList) {
    this.vList = vList;
  }

  @Override
  public String toString() {
    return "Texture{" +
            "vList=" + vList +
            ", vtList=" + vtList +
            ", vnList=" + vnList +
            ", fList=" + fList +
            '}';
  }

  public List<VT> getVtList() {
    return vtList;
  }

  public void setVtList(List<VT> vtList) {
    this.vtList = vtList;
  }

  public List<VN> getVnList() {
    return vnList;
  }

  public void setVnList(List<VN> vnList) {
    this.vnList = vnList;
  }

  public List<F> getfList() {
    return fList;
  }

  public void setfList(List<F> fList) {
    this.fList = fList;
  }
}
