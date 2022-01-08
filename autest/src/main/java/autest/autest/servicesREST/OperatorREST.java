package autest.autest.servicesREST;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import autest.autest.entities.Num;
import autest.autest.entities.Operator;
import autest.autest.repositories.NumRepository;
import autest.autest.repositories.OperatorRepository;

@RestController
@RequestMapping("operators")
public class OperatorREST 
{
    @Autowired
    private OperatorRepository operatorRepository;

    @Autowired
    private NumRepository numRepository;

    @GetMapping
    public ResponseEntity<List<Operator>> getOperators()
    {
       List<Operator> nums = operatorRepository.findAll();
    
       return ResponseEntity.ok(nums);
        
    }

    @RequestMapping(value="{operatorId}")
    public ResponseEntity<Operator> getOperatorById(@PathVariable("operatorId") Long operatorId)
    {
       Optional<Operator> op = operatorRepository.findById(operatorId);
       if(op.isPresent())
       {
           
           return ResponseEntity.ok(op.get());
       }
       else
       {
            return ResponseEntity.noContent().build();
       }
        
    }

    @PostMapping
    public ResponseEntity<Operator> addOperator(@RequestBody Operator operator)
    {
        Operator newOp = operatorRepository.save(operator);
        List<Num> nums = numRepository.findAll();
        String operatorUse = newOp.getOperator();
        Integer value = 0;
        
        if(operatorUse.equals("+"))
        {
            for(int i = 0; i<nums.size();i++)
            {
                value+= nums.get(i).getNum();
            }

        }
        else if(operatorUse.equals("-"))
        {
            value = nums.get(0).getNum();
            for(int i = 1; i<nums.size();i++)
            {
                value-= nums.get(i).getNum();
            }

        }
        else if(operatorUse.equals("*"))
        {
            value = nums.get(0).getNum();
            for(int i = 1; i<nums.size();i++)
            {
                value*= nums.get(i).getNum();
            }

        }
        else if(operatorUse.equals("/"))
        {
            value = nums.get(0).getNum();
            for(int i = 1; i<nums.size();i++)
            {
                value/= nums.get(i).getNum();
            }

        }

        newOp.setValue(value);

        return ResponseEntity.ok(newOp);

    }


}
