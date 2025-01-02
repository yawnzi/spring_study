package com.example.sboot.service;

import com.example.sboot.entity.Customer;
import com.example.sboot.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    //회원등록
    public Customer register(Customer customer) {
        return customerRepository.save(customer);  //save() -> insert SQL
    }

    //회원 목록 가져오기(+리뷰:List<Review>, +장바구니:list<Cart>)
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();  //select SQL
    }

    //특정 회원 한명의 정보 가져오기
    public Optional<Customer> getById(Long id) {  //PK(id)
        return customerRepository.findById(id);  //select where~
        // select * from Customer where id = ?
    }

    //특정 회원의 정보를 수정하기
    public void cusUpdate(Long id, Customer customer){
        Optional<Customer> optional=customerRepository.findById(id);
        Customer dbCustomer;
        if(optional.isPresent()){
            dbCustomer=optional.get();
        }else{
            throw new IllegalArgumentException("error");
        }
        dbCustomer.setUsername(customer.getUsername()); // 아이디
        dbCustomer.setAge(customer.getAge()); // 나이
        customerRepository.save(dbCustomer); // update SQL
    }

    //회원 삭제
    public void cusDelete(Long id){ // id
        customerRepository.deleteById(id); // delete ~ where id=id
    }

}
