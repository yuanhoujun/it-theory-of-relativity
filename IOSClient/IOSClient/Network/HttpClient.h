//
//  HttpClient.h
//  IOSClient
//
//  Created by 欧阳锋 on 17/03/2018.
//  Copyright © 2018 xbdx. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface HttpClient : NSObject

+ (nonnull HttpClient *)initWithBaseUrl: (nonnull NSString *)baseUrl;
+ (nonnull HttpClient *)sharedInstance;

@property (nonatomic, assign, nullable) NSString *baseUrl;

- (void)POST: (nonnull NSString *) url
      params: (nullable NSDictionary *) params
     success: (nullable void (^)(NSString *url, id data)) success
       error: (nullable void (^)(NSString *url, NSInteger httpCode, NSInteger bizCode, NSString* error)) error;


@end
