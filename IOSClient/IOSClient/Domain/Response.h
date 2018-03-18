//
//  Response.h
//  IOSClient
//
//  Created by 欧阳锋 on 17/03/2018.
//  Copyright © 2018 xbdx. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <JSONModel.h>

@interface Response : JSONModel

typedef NS_ENUM(NSInteger, Code) {
    SUCCESS = 0,
    USER_NOT_EXISTS = 1,
    USER_PWD_ERR = 2,
    USER_HAS_EXIST = 3
};

typedef NS_ENUM(NSInteger, HttpCode) {
    SC_OK = 200
};

@end
