//
//  RegisterViewController.m
//  IOSClient
//
//  Created by 欧阳锋 on 17/03/2018.
//  Copyright © 2018 xbdx. All rights reserved.
//

#import "RegisterViewController.h"
#import "StringUtil.h"
#import "HttpClient.h"

@interface RegisterViewController ()

@property (weak, nonatomic) IBOutlet UITextField *mUsernameTextField;
@property (weak, nonatomic) IBOutlet UITextField *mPwdTextField;
@property (weak, nonatomic) IBOutlet UITextField *mConfirmTextField;

@end

@implementation RegisterViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (IBAction)register:(id)sender {
    NSString *username = _mUsernameTextField.text;
    NSString *pwd = _mPwdTextField.text;
    NSString *confrimPwd = _mConfirmTextField.text;
    
    if([StringUtil isBlankString: username]) {
        [self promptError: @"请输入用户名"];
        return;
    }
    
    if([StringUtil isBlankString: pwd]) {
        [self promptError: @"请输入用户密码"];
        return;
    }
    
    if([StringUtil isBlankString: confrimPwd]) {
        [self promptError: @"请输入确认密码"];
        return;
    }
    
    if(![pwd isEqualToString: confrimPwd]) {
        [self promptError: @"两次密码输入不一致，请重新输入"];
        return;
    }
    
    HttpClient *client = [HttpClient sharedInstance];
    [client POST: @"/user/register" params: @{@"username" : username, @"pwd" : pwd} success:^(NSString *url, id data) {
        [self promptError: @"注册成功" handler:^(UIAlertAction *action) {
            [self.navigationController popViewControllerAnimated: YES];
        }];
    } error:^(NSString *url, NSInteger httpCode, NSInteger bizCode, NSString *error) {
        [self promptError: error];
    }];
}



/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
