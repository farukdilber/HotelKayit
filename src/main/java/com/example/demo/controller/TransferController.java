package com.example.demo.controller;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Transfer;
import com.example.demo.repository.TransferRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/transfer")
public class TransferController {

    private final TransferRepository transferRepository;

    @GetMapping("/{id}")
    public Transfer getTransfer(@PathVariable Long id){
        return transferRepository.getById(id);
    }


    @GetMapping("/all")
    public List<Transfer> getAllTransfers(){
        return transferRepository.findAll();
    }


    @PostMapping("/add")
    public void add(@RequestBody Transfer transfer){
        transferRepository.save(transfer);
    }

    @PutMapping("/{id}/update")
    public void uptade(@PathVariable Long id,@RequestBody Transfer transfer){
        Transfer transfer1 = transferRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Boyle bır kayıt bulunamadı"));
        Transfer transfer2 = new Transfer(id,transfer1.getCustomer()
                ,transfer1.getPickUpTime(),transfer.getDropOffTime(),transfer1.getPickUpLocation()
        ,transfer.getDropOffLocation(),transfer.getFlightNo(),transfer.getStatus(),transfer.getTotalPrice());
        transferRepository.save(transfer2);
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable Long id){
        transferRepository.deleteById(id);

    }

}
