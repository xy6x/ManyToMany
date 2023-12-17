package com.example.schoolmanagement.Service;

import com.example.schoolmanagement.ApiException.ApiException;
import com.example.schoolmanagement.DOT.AddressDTO;
import com.example.schoolmanagement.Model.Address;
import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Repository.AddressRepository;
import com.example.schoolmanagement.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;
    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }
public void addAddress(AddressDTO addressDTO){
    Teacher teacher =teacherRepository.findTeacherById(addressDTO.getTeacher_id());
    if (teacher == null) {
        throw new ApiException("the teacher not found");
    }
    Address address=new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
    addressRepository.save(address);
}
public void updateAddress(Integer id,Address address){
        Address oldAddress=addressRepository.findAddressById(id);
    if (oldAddress == null) {
        throw new ApiException("the teacher not found");
    }
    oldAddress.setArea(address.getArea());
    oldAddress.setStreet(address.getStreet());
    oldAddress.setBuildingNumber(oldAddress.getBuildingNumber());
    addressRepository.save(oldAddress);
}
public void deleteAddress(Integer id){
Teacher teacher =teacherRepository.findTeacherById(id);
    if (teacher != null) {
        teacher.setAddress(null);

    }
    Address address =addressRepository.findAddressById(id);
    addressRepository.delete(address);
}
}
