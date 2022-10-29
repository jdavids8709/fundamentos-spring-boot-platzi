package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos.dto.TestDTO;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
    @Qualifier("componentTwoImpl")
    @Autowired
    private ComponentDependency componentDependency;
    @Autowired
    private MyBean myBean;
    @Autowired
    private MyBeanWithDependency myBeanWithDependency;
    @Autowired
    private MyBeanWithProperties myBeanWithProperties;

    @Autowired
    private TestDTO testDTO;

    @Autowired
    private UserRepository userRepository;

    Log log = LogFactory.getLog(FundamentosApplication.class);

    /*public FundamentosApplication(@Qualifier("componentTwoImpl") ComponentDependency componentDependency,
                                   MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties) {
        this.componentDependency = componentDependency;
        this.myBean = myBean;
        this.myBeanWithDependency = myBeanWithDependency;
        this.myBeanWithProperties = myBeanWithProperties;
    }*/

    public static void main(String[] args) {
        SpringApplication.run(FundamentosApplication.class, args);
    }

    @Override
    public void run(String... args) {
        componentDependency.helloWorld(); myBean.print(); myBeanWithDependency.printWithDependency();
        System.out.println(myBeanWithProperties.load()); System.out.println(testDTO.toString());
        log.info("This is a application error");


        jpaActions();
    }

    private void jpaActions() {
        try {
            User user = new User("David", "davidsalcedo87@gmail.com", LocalDate.of(1987, 9, 30));
            User user2 = new User("Carolina", "car@gmail.com", LocalDate.of(1986, 9, 27));
            User user3 = new User("Karen", "karen@gmail.com", LocalDate.of(2013, 8, 10));
            User user4 = new User("David Jose", "jose@gmail.com", LocalDate.of(1987, 9, 30));
            User user5 = new User("Maria", "maria@gmail.com", LocalDate.of(1956, 10, 06));
            List<User> list = Arrays.asList(user, user2, user3, user4, user5);

            //            list.forEach(userRepository::save);
            userRepository.saveAll(list);
            log.info(userRepository.findByEmai("car@gmail.com").orElseThrow(() -> new RuntimeException("User no found by email parameter")));

            userRepository.findBySort("Da", Sort.by("id").descending())
                    .forEach(userFind -> log.info("User is: " + userFind));
            ;

            userRepository.findByName("David").forEach(userF->log.info("findByName: " +userF));

            log.info(userRepository.findByEmailAndName("car@gmail.com","Carolina").orElseThrow(()-> new RuntimeException(
                    "findByEmaiAndName no exists")));

            userRepository.findByNameLike("%ar%").forEach(userF->log.info("findByNameLike: " +userF));

            log.info("findByEmailOrName:" +
                     userRepository.findByEmailOrName("car@gmail.com","Carolina")
                             .orElseThrow(()-> new RuntimeException("findByEmailOrName no exists")));

            userRepository.findByBirthdayBetween(LocalDate.of(1988,01,01),LocalDate.of(2022,10,29))
                    .forEach(userF2->log.info("findByBirthdayBetween: " +userF2));

            userRepository.findByNameLikeOrderByIdDesc("%ar%").
                    forEach(userFind -> log.info("findByNameLikeOrderByDesc: " + userFind));

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

}
