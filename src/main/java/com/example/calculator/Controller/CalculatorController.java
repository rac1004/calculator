package com.example.calculator.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;


//Without using Switch

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
   private static final DecimalFormat decfor = new DecimalFormat("0.00");
    private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    //calculator/add?num1=2&num2=3
    @GetMapping("/add")
    public double add(@RequestParam double num1, @RequestParam double num2) {
        double sum=num1 + num2;
        logger.info("Addition of two number: "+sum );
        return sum;

    }

    //calculator/substract?num1=5&num2=3
    @GetMapping("/substract")
    public double subtract(@RequestParam double num1, @RequestParam double num2) {
        double sub = num1 - num2;
        logger.info("Substraction of two number: "+ sub );
        return sub;
    }

    //calculator/multiply?num1=4&num2=2 for multiplication
    @GetMapping("/multiply")
    public double multiply(@RequestParam double num1, @RequestParam double num2) {
        double add = num1 * num2;
        logger.info("Addition of two number: "+ add );
        return  add;
    }

    //calculator/divide?num1=8&num2=2 for division
    @GetMapping("/divide")
    public double divide(@RequestParam double num1, @RequestParam double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        double div = num1 / num2;
        logger.info("Divide of Two number: " +  decfor.format(div));
        return div;
    }
}



////With using switch
//@RestController
//@RequestMapping("/calculator")
//public class CalculatorController {
//
//    private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);
//    private static final DecimalFormat decfor = new DecimalFormat("0.00");
//    @GetMapping("/calculate")
//    public double calculate(
//            @RequestParam double num1,
//            @RequestParam double num2,
//            @RequestParam String operation
//    ) {
//        switch (operation) {
//            //To add: /calculator/calculate?num1=5&num2=3&operation=add
//            case "add":
//                double sum = num1 + num2;
//                logger.info("Addition of two number: "+ sum );
//                return sum;
//
//            //To subtract: /calculator/calculate?num1=5&num2=3&operation=subtract
//            case "subtract":
//                double sub = num1 - num2;
//                logger.info("Substraction of two number: "+ sub );
//                return sub;
//
//            //To multiply: /calculator/calculate?num1=4&num2=2&operation=multiply
//            case "multiply":
//                double mul = num1 * num2;
//                logger.info("Multipication of Two number: " + mul);
//                return mul;
//
//            //To divide: /calculator/calculate?num1=8&num2=2&operation=divide
//            case "divide":
//                if (num2 == 0) {
//                    throw new IllegalArgumentException("Division by zero is not allowed.");
//                }
//                double div = num1 / num2;
//                logger.info("Divide of Two number: " +  decfor.format(div));
//                return div;
//            default:
//                throw new IllegalArgumentException("Invalid operation: " + operation);
//        }
//    }
//}
