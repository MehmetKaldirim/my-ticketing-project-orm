package com.cydeo.service.impl;

import com.cydeo.dto.RoleDTO;
import com.cydeo.entity.Role;
import com.cydeo.mapper.RoleMapper;
import com.cydeo.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements com.cydeo.service.RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public List<RoleDTO> listAllRoles() {


        // controlling calling me and want all roles and where they are in Repository
        //how can i call them of coz injection

        List<Role> roleList = roleRepository.findAll();
        //here i need mechanism convert roleList to RoleDTO = it is Mapper a new Story begin
        List<RoleDTO> list2= roleList.stream().map(roleMapper :: convertToDto).collect(Collectors.toList());
        return list2;
    }

    @Override
    public RoleDTO findById(Long id) {

        return roleMapper.convertToDto(roleRepository.findById(id).get());
    }
}
