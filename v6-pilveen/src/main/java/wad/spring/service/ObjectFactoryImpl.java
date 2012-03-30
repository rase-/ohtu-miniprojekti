package wad.spring.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import wad.spring.domain.SampleObject;

@Service
public class ObjectFactoryImpl implements ObjectFactory {

    @Override
    public List<SampleObject> getObjects() {
        List<SampleObject> list = new ArrayList();

        list.add(new SampleObject(true));
        list.add(new SampleObject(false));

        return list;
    }
}
