package com.lms.api.mapper;

import com.lms.api.dto.LibraryDTO;
import com.lms.api.entities.Library;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityMapper {

    @Autowired
    private ModelMapper modelMapper;

    public LibraryDTO toLibraryDTO(Library library) {
        if (library == null) {
            return null;
        }

        LibraryDTO libraryDTO = new LibraryDTO();

        libraryDTO.setId(library.getId());
        libraryDTO.setName(library.getName());
        libraryDTO.setCreatedAt(library.getCreatedAt());
        libraryDTO.setUpdatedAt(library.getUpdatedAt());

        return libraryDTO;
    }

    public List<LibraryDTO> toLibraryDTOList(List<Library> libraries) {
        return libraries.stream()
                .map(this::toLibraryDTO)
                .collect(Collectors.toList());
    }
}
