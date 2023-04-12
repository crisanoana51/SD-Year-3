package labactivity.businessService;

import labactivity.model.LabClass;
import labactivity.persistanceLayer.LabClassRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabClassService {

    private final LabClassRepo labClassRepo;


    @Autowired
    public LabClassService(LabClassRepo labClassRepo)
    {
        this.labClassRepo = labClassRepo;
    }

    public LabClass addLabClass(LabClass labClass){

        return labClassRepo.save(labClass);
    }

    public List<LabClass> findAllLabClasses(){
        return labClassRepo.findAll();
    }

    public LabClass updateLabClass(LabClass labClass){

        return labClassRepo.save(labClass);
    }


    public void deleteLabClass(int nr){
        labClassRepo.deleteById(nr);
    }
}
