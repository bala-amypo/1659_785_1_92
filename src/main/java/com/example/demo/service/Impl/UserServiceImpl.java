package com.example.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.UserService;
import com.example.demo.repository.UserRepository;
import com.example.demo.model.User;




@Service
 public class UserServiceImpl implements UserService{ 
          @Autowired UserRepository  userrepo;

          @Override
        public  User register(User user){
        return userrepo.save(user);
        }
        @Override
        public User findByEmail(String email){
            return userrepo.findByEmail(email);
        }
    
 }




































// package com.example.demo.service.Impl;
// import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.stereotype.Service;
// import com.example.demo.repository.Studentrepo;
// import com.example.demo.entity.Studententity;
// import com.example.demo.service.Studentservice;
// import java.util.List;
// @Service  
// public class StudentserviceImpl implements Studentservice{   //splited as 2 layers here
//             @Autowired Studentrepo student; 
//             //save()-insert,update
//             //findall(),findById(),deleteById(),existById()
//             @Override
//             public  Studententity postData(Studententity stu){
//                return student.save(stu);
//             }
//             @Override
//             public   List<Studententity>getAllData(){
//                return student.findAll();
//             }
//             @Override
//              public String delete(int id){
//                  student.deleteById(id);  // if add return ,it will give error
//                  return "Deleted Successfully";
//              }
//             @Override
//             public  Studententity getData(int id){          //return type:Studententity ,gives error -> so add orElse(null)
//                return student.findById(id).orElse(null);
//             }
//             @Override
//             public  Studententity updatedata(int id,Studententity entity){
//                if(student.existsById(id)){
//                   entity.setId(id);
//                   return student.save(entity);
//                }
//                return null;
//             }

// }
