package com.aeliter.study.thread;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @description:
 * @author: caibingqiang
 * @date: 2020-07-17 10:14
 * @version: V1.0
 */
@NoArgsConstructor
@Getter
@Setter
public class Person {

    private Integer id;
    private String personName;

    public Person(String personName) {
        this.personName = personName;
    }

}
