package com.ekfet.boot.controller;

import com.ekfet.boot.model.PetModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author radish.zhou
 * @version v 1.0
 * @ClassName: TestController
 * @date 2018/11/3 11:36
 */
@RestController
@RequestMapping("/boot")
public class BootController {


    @RequestMapping("/string")
    public Object getString() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "radish");

        return map;
    }

    @GetMapping(value = {"pet"},produces = "application/json;charset=UTF-8")
    public PetModel getPet(String name){
        PetModel petModel=new PetModel();
        petModel.setColor("red");
        petModel.setName(name);
        return petModel;
    }

    @GetMapping("/p1/{ownerId}/p2/{petId}")
    public int[] findPet(
            @MatrixVariable(name="p1", pathVar="ownerId") int ownerId,
            @MatrixVariable(name="p2", pathVar="petId") int petId) {
        System.out.println("======");
        return new int[]{ownerId,petId};

    }

}
