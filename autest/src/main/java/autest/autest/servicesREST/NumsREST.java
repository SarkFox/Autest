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
import autest.autest.repositories.NumRepository;

@RestController
@RequestMapping("nums")
public class NumsREST 
{

    @Autowired
    private NumRepository numRepository;

    @GetMapping
    public ResponseEntity<List<Num>> getNum()
    {
       List<Num> nums = numRepository.findAll();
    
       return ResponseEntity.ok(nums);
        
    }

    @RequestMapping(value="{numId}")
    public ResponseEntity<Num> getNumById(@PathVariable("numId") Long numId)
    {
       Optional<Num> num = numRepository.findById(numId);
       if(num.isPresent())
       {
           
           return ResponseEntity.ok(num.get());
       }
       else
       {
            return ResponseEntity.noContent().build();
       }
        
    }

    @PostMapping
    public ResponseEntity<Num> addNum(@RequestBody Num num)
    {
        Num newNum = numRepository.save(num);
        return ResponseEntity.ok(newNum);

    }

    //@GetMapping
    public String hey()
    {
        return "NAISUUUUU";
    }

    
}
