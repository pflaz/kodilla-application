package com.crud.tasks.mapper;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.dto.TrelloBoardDto;
import com.crud.tasks.dto.TrelloCardDto;
import com.crud.tasks.dto.TrelloListDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

public class TrelloMapperTestSuite {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void testMapToBoards() {
        // Given

        TrelloListDto trelloListDto1 = new TrelloListDto("list1", "list name 1", false);
        TrelloListDto trelloListDto2 = new TrelloListDto("list2", "list name 2", true);
        List<TrelloListDto> listsDto1 = new ArrayList<>();
        listsDto1.add(trelloListDto1);
        listsDto1.add(trelloListDto2);
        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("board1", "board name 1", listsDto1);

        TrelloListDto trelloListDto3 = new TrelloListDto("list3", "list name 3", false);
        TrelloListDto trelloListDto4 = new TrelloListDto("list4", "list name 4", true);
        List<TrelloListDto> listsDto2 = new ArrayList<>();
        listsDto2.add(trelloListDto3);
        listsDto2.add(trelloListDto4);
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("board2", "board name 2", listsDto2);

        List<TrelloBoardDto> trelloBoardsDto = new ArrayList<>();
        trelloBoardsDto.add(trelloBoardDto1);
        trelloBoardsDto.add(trelloBoardDto2);

        TrelloList trelloList1 = new TrelloList("list1", "list name 1", false);
        TrelloList trelloList2 = new TrelloList("list2", "list name 2", true);
        List<TrelloList> lists1 = new ArrayList<>();
        lists1.add(trelloList1);
        lists1.add(trelloList2);
        TrelloBoard trelloBoard1 = new TrelloBoard("board1", "board name 1", lists1);

        TrelloList trelloList3 = new TrelloList("list3", "list name 3", false);
        TrelloList trelloList4 = new TrelloList("list4", "list name 4", true);
        List<TrelloList> lists2 = new ArrayList<>();
        lists2.add(trelloList3);
        lists2.add(trelloList4);
        TrelloBoard trelloBoard2 = new TrelloBoard("board2", "board name 2", lists2);

        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(trelloBoard1);
        trelloBoards.add(trelloBoard2);

        // When
        List<TrelloBoard> retrievedTrelloBoards = trelloMapper.mapToBoards(trelloBoardsDto);

        // Then
       Assert.assertEquals(retrievedTrelloBoards, trelloBoards);

    }

    @Test
    public void testMapToDtoBoards() {
        // Given

        TrelloListDto trelloListDto1 = new TrelloListDto("list1", "list name 1", false);
        TrelloListDto trelloListDto2 = new TrelloListDto("list2", "list name 2", true);
        List<TrelloListDto> listsDto1 = new ArrayList<>();
        listsDto1.add(trelloListDto1);
        listsDto1.add(trelloListDto2);
        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("board1", "board name 1", listsDto1);

        TrelloListDto trelloListDto3 = new TrelloListDto("list3", "list name 3", false);
        TrelloListDto trelloListDto4 = new TrelloListDto("list4", "list name 4", true);
        List<TrelloListDto> listsDto2 = new ArrayList<>();
        listsDto2.add(trelloListDto3);
        listsDto2.add(trelloListDto4);
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("board2", "board name 2", listsDto2);

        List<TrelloBoardDto> trelloBoardsDto = new ArrayList<>();
        trelloBoardsDto.add(trelloBoardDto1);
        trelloBoardsDto.add(trelloBoardDto2);

        TrelloList trelloList1 = new TrelloList("list1", "list name 1", false);
        TrelloList trelloList2 = new TrelloList("list2", "list name 2", true);
        List<TrelloList> lists1 = new ArrayList<>();
        lists1.add(trelloList1);
        lists1.add(trelloList2);
        TrelloBoard trelloBoard1 = new TrelloBoard("board1", "board name 1", lists1);

        TrelloList trelloList3 = new TrelloList("list3", "list name 3", false);
        TrelloList trelloList4 = new TrelloList("list4", "list name 4", true);
        List<TrelloList> lists2 = new ArrayList<>();
        lists2.add(trelloList3);
        lists2.add(trelloList4);
        TrelloBoard trelloBoard2 = new TrelloBoard("board2", "board name 2", lists2);

        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(trelloBoard1);
        trelloBoards.add(trelloBoard2);

        // When
        List<TrelloBoardDto> retrievedTrelloBoardsDto = trelloMapper.mapToBoardsDto(trelloBoards);

        // Then
        Assert.assertEquals(retrievedTrelloBoardsDto, trelloBoardsDto);

    }

    @Test
    public void testMapToCardDto() {
        // Given
        TrelloCard trelloCard = new TrelloCard("card name", "card description", "pos", "listId");
        TrelloCardDto trelloCardDto = new TrelloCardDto("card name", "card description", "pos", "listId");

        // When
        TrelloCardDto retrievedTrelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        // Then
        Assert.assertEquals(trelloCardDto.getName(), retrievedTrelloCardDto.getName());
        Assert.assertEquals(trelloCardDto.getDescription(), retrievedTrelloCardDto.getDescription());
        Assert.assertEquals(trelloCardDto.getPos(), retrievedTrelloCardDto.getPos());
        Assert.assertEquals(trelloCardDto.getListId(), retrievedTrelloCardDto.getListId());
    }

    @Test
    public void testMapToCard() {
        // Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("card name", "card description", "pos", "listId");
        TrelloCard trelloCard = new TrelloCard("card name", "card description", "pos", "listId");

        // When
        TrelloCard retrievedTrelloCard = trelloMapper.mapToCard(trelloCardDto);

        // Then
        Assert.assertEquals(trelloCard.getName(), retrievedTrelloCard.getName());
        Assert.assertEquals(trelloCard.getDescription(), retrievedTrelloCard.getDescription());
        Assert.assertEquals(trelloCard.getPos(), retrievedTrelloCard.getPos());
        Assert.assertEquals(trelloCard.getListId(), retrievedTrelloCard.getListId());
    }

}