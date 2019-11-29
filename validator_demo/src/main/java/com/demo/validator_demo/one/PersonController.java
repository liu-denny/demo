package com.demo.validator_demo.one;

import com.demo.validator_demo.BeanValidator;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author yudong
 * @create 2019-11-14 10:47
 */
@RestController
@RequestMapping("/api")
@Api(value = "测试Controller1", tags = {"测试Controller1"})
public class PersonController {



    @PostMapping("/person")
    public ResponseEntity<Person> getPerson(@RequestBody @Valid Person person) {
        return ResponseEntity.ok().body(person);
    }

    @PostMapping("/person1")
    public ResponseEntity<Person> getPerson1(@RequestBody Person person) {
        BeanValidator.check(person);
        return ResponseEntity.ok().body(person);
    }


}
