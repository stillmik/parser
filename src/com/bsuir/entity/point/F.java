package com.bsuir.entity.point;

import java.util.ArrayList;

public class F {

  public ArrayList<V_VT> v_vt = new ArrayList<>();
  public ArrayList<V_VT_VN> v_vt_vn = new ArrayList<>();
  public ArrayList<V_VN> v_vn = new ArrayList<>();

  public ArrayList<Double> v = new ArrayList<>();

   @Override
   public String toString() {
      return "F{" +
              "v_vt=" + v_vt +
              ", v_vt_vn=" + v_vt_vn +
              ", v_vn=" + v_vn +
              ", v=" + v +
              '}';
   }
}
