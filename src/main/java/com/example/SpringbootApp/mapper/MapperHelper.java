package com.example.SpringbootApp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.SpringbootApp.dto.UserDTO;
import com.example.SpringbootApp.modelo.UserVO;

@Mapper
public interface MapperHelper {
	
	public MapperHelper INSTANCE = Mappers.getMapper(MapperHelper.class);

	@Mapping(target = "nif", source = "entity.nif")
	@Mapping(target =  "name", source = "entity.name")
	@Mapping(target = "lastName", source = "entity.lastName")
	@Mapping(target =  "dateBirth", source = "entity.dateBirth")
	public UserDTO userVoToUserDto(UserVO entity);


	@Mapping(target = "nif", source = "entity.nif")
	@Mapping(target =  "name", source = "entity.name")
	@Mapping(target = "lastName", source = "entity.lastName")
	@Mapping(target =  "dateBirth", source = "entity.dateBirth")
	public UserVO userDtoToUserVo(UserDTO entity);
}
