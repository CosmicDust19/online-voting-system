package edu.estu.ovs.business.abstracts;

import edu.estu.ovs.core.utilities.results.DataResult;
import edu.estu.ovs.models.entities.Election;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ElectionService {
    DataResult<List<Election>> getAll();
}
