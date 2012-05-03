//
//  SquareClass.m
//  Aoc2_W1
//
//  Created by Luis Puente on 5/2/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "SquareClass.h"

@implementation SquareClass

-(id)init
{
    self = [super init];
    if(self != nil)
    {
        _numSides = 4; //square has 4 sides
        _name = @"Square";
    }
    return self;
}

-(int)GetArea
{
    return (4.0f * 4.0f); //base * height
}



@end
