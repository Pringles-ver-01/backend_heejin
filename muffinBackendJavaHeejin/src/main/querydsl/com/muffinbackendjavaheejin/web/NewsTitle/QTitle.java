package com.muffinbackendjavaheejin.web.NewsTitle;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTitle is a Querydsl query type for Title
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTitle extends EntityPathBase<Title> {

    private static final long serialVersionUID = 2066803978L;

    public static final QTitle title = new QTitle("title");

    public final NumberPath<Long> titleId = createNumber("titleId", Long.class);

    public final StringPath titleName = createString("titleName");

    public QTitle(String variable) {
        super(Title.class, forVariable(variable));
    }

    public QTitle(Path<? extends Title> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTitle(PathMetadata metadata) {
        super(Title.class, metadata);
    }

}

