package com.jcrafters.stockmarket.crawler.mapper;

import com.jcrafters.commons.FullOffsetDateTimeMapper;
import com.jcrafters.stockmarket.crawler.jpa.StockDataFeed;
import com.jcrafters.stockmarket.crawler.service.dto.StockDataFeedDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {FullOffsetDateTimeMapper.class})
public interface StockDataFeedMapper {

    StockDataFeedMapper
            INSTANCE = Mappers.getMapper(StockDataFeedMapper.class);

    StockDataFeedDto toDto(StockDataFeed jpa);

    StockDataFeed toJpa(StockDataFeedDto dto);

    List<StockDataFeedDto> toDtos(List<StockDataFeed> jpas);

}
