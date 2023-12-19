package com.twoTeam.groupProject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "post_comment")
public class PostCommentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "postcm_id")
    private int postcmId;
    @Basic
    @Column(name = "post_id")
    private int postId;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "comment")
    private String comment;
    @Basic
    @Column(name = "store_id")
    private int storeId;

}
