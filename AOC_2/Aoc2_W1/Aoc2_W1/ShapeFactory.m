//
//  ShapeFactory.m
//  Aoc2_W1
//
//  Created by Luis Puente on 5/2/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "ShapeFactory.h"
#import "ShapeClass.h"
#import "TriangleClass.h"
#import "SquareClass.h"
#import "RectangleClass.h"



@implementation ShapeFactory


-(ShapeClass*)CreateShape:(NSInteger)shapeType; //used shapeType instead of index. Makes more sense to what its calling//
{
       if(shapeType == 0)
       {
           return [[SquareClass alloc] initWithDetails:4 name:@"Square"];
       }
       else if(shapeType == 1)
       {
           return [[TriangleClass alloc] initWithDetails:3 name:@"Triangle"];
       }
       else if(shapeType == 2)
       {
           return [[RectangleClass alloc] initWithDetails:6 name:@"Rectangle"];
       }
       else
       {
           return nil;
       }
}

@end
