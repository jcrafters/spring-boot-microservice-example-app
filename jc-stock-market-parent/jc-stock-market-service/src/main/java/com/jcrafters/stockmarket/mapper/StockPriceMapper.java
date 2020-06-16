package com.jcrafters.stockmarket.mapper;

import com.jcrafters.commons.FullOffsetDateTimeMapper;
import com.jcrafters.stockmarket.jpa.StockPrice;
import com.jcrafters.stockmarket.service.dto.StockPriceDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {FullOffsetDateTimeMapper.class})
public interface StockPriceMapper {

    StockPriceMapper
            INSTANCE = Mappers.getMapper(StockPriceMapper.class);

    StockPriceDto toDto(StockPrice jpa);

    StockPrice toJpa(StockPriceDto dto);

    List<StockPriceDto> toDtos(List<StockPrice> jpas);
}
