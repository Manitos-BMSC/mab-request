package bo.edu.ucb.mabrequest.Bl;

import bo.edu.ucb.mabrequest.dao.Cycle;
import bo.edu.ucb.mabrequest.dao.repository.CycleRepository;
import bo.edu.ucb.mabrequest.Dto.CycleDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CycleBl {

    @Autowired
    CycleRepository cycleRepository;

    private final Logger logger = LoggerFactory.getLogger(CycleBl.class);
    public CycleDto getCurrentCycle(){
        Cycle currentCycle = cycleRepository.findFirstByOrderByCycleIdDesc();
        if(currentCycle == null){
            logger.info("getCurrentCycle: currentCycle is null");
            return null;
        }
        CycleDto cycleDto = new CycleDto();
        cycleDto.setCycleId(currentCycle.getCycleId());
        cycleDto.setCycleYear(currentCycle.getCycleYear());
        cycleDto.setDateEndRegistry(currentCycle.getDateEndRegistry());
        cycleDto.setMaxDoctors(currentCycle.getMaxDoctors());
        cycleDto.setMaxPatients(currentCycle.getMaxPatients());
        logger.info("getCurrentCycle: " + cycleDto);
        return cycleDto;
    }

    public CycleDto createCycle(CycleDto cycleDto){
        logger.info("createCycle: " + cycleDto);
        Cycle cycle = new Cycle();
        cycle.setCycleYear(cycleDto.getCycleYear());
        cycle.setMaxDoctors(cycleDto.getMaxDoctors());
        cycle.setMaxPatients(cycleDto.getMaxPatients());
        cycle.setDateEndRegistry(cycleDto.getDateEndRegistry());
        cycle.setState("ACTIVO");
        cycle.setStatus(1);
        logger.info("saving new cycle");
        cycleRepository.save(cycle);
        return cycleDto;
    }

}
