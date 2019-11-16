package org.cloud.ssm.service.impl;

import org.cloud.ssm.entity.Person;
import org.cloud.ssm.mapper.PersonMapper;
import org.cloud.ssm.service.PersonService;
import org.cloud.ssm.utils.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends BaseServiceImpl<PersonMapper, Person> implements PersonService {

}
