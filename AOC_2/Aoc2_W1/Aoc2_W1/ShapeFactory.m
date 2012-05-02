//
//  ShapeFactory.m
//  Aoc2_W1
//
//  Created by Luis Puente on 5/2/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "ShapeFactory.h"

@implementation ShapeFactory


+(id)CreateShape:(NSInteger)shapeType; //used shapeType instead of index. Makes more sense to what its calling//
{
       if(shapeType == 0)
       {
           return [[SquareClass alloc] init];
       }
       else if(shapeType == 1)
       {
           return [[TriangleClass alloc] init];
       }
       else //I'm not sure how to make it specifcally say "2" but if its not 0 ir 1 it must be 2
       {
           return [[RectangleClass alloc] init];
       }
}

@end
