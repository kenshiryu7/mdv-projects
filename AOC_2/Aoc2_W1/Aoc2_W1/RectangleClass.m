//
//  RectangleClass.m
//  Aoc2_W1
//
//  Created by Luis Puente on 5/2/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "RectangleClass.h"
#import "ShapeClass.h"

@implementation RectangleClass

-(id)init
{
    self = [super init];
    if(self != nil)
    {
        _numSides = 6; //Can't set to 4 bc square is 4. Try 6.
        _name = @"Triangle";
    }
    return self;
}

-(int)GetArea
{
    return (5.0f * 12.0f); //base * height
}



@end
