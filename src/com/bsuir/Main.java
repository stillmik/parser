package com.bsuir;

import com.bsuir.entity.Texture;
import com.bsuir.parser.FileParser;

public class Main {

  public static void main(String[] args) {

    FileParser fileParser = new FileParser();
    String iPhone = "data/Iphone seceond version finished.obj";
    String person = "data/FinalBaseMesh.obj";
    Texture texture = fileParser.parse(person);
    System.out.println(texture);
  }
}
