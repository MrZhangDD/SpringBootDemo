package com.zhang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Books {

    private String bookName;
    private String detail;
    private int bookCounts;
    private int bookId;
}
