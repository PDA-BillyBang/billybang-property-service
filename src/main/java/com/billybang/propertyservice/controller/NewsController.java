package com.billybang.propertyservice.controller;

import com.billybang.propertyservice.api.ApiResult;
import com.billybang.propertyservice.api.ApiUtils;
import com.billybang.propertyservice.api.NewsApi;
import com.billybang.propertyservice.model.entity.News;
import com.billybang.propertyservice.model.dto.request.NewsRequestDto;
import com.billybang.propertyservice.service.NewsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class NewsController implements NewsApi {
    private final NewsService newsService;

    public ResponseEntity<ApiResult<List<News>>> findNews(NewsRequestDto requestDto){
        List<News> newsList = newsService.findNews(requestDto);
        return ResponseEntity.ok(ApiUtils.success(newsList));
    }
}
