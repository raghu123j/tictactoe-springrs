package com.labtwin.raghu.tictactoespringrs.vo;

import lombok.*;

import java.io.Serializable;
import java.util.function.Supplier;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor
public class UserInfo implements Serializable {

    @NonNull
    private int userId;
    private String userName;

}
