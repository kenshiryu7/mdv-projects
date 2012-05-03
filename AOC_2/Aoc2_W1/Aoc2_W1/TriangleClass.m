//
//  TriangleClass.m
//  Aoc2_W1
//
//  Created by Luis Puente on 5/2/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "TriangleClass.h"

@implementation TriangleClass

-(id)init
{
    self = [super init];
    if(self != nil)
    {
        _numSides = 3; //triangle has 3 sides
        _name = @"Triangle";
    }
    return self;
}


-(int)GetArea
{
    return 0.5f *(8.0f * 12.0f); //0.5 * (base * height)
}



@end
