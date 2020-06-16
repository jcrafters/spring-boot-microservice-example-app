package com.jcrafters.stockmarket.mapper;

import com.jcrafters.commons.FullOffsetDateTimeMapper;
import com.jcrafters.stockmarket.jpa.Stock;
import com.jcrafters.stockmarket.service.dto.StockDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {FullOffsetDateTimeMapper.class})
public interface StockMapper {

    StockMapper
            INSTANCE = Mappers.getMapper(StockMapper.class);

    StockDto toDto(Stock jpa);

    Stock toJpa(StockDto dto);

    List<StockDto> toDtos(List<Stock> jpas);
}
