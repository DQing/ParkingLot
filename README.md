## ParkingLot

Given 一个初始停车位为20的停车场，且空余车位为1 When 停车 Then 停车成功并打印小票，且空余车位为0
Given 一个初始停车位为20的停车场，且空余车位为0 When 停车 Then 停车失败
Given 一个初始停车位为20的停车场，且空余车位为0和有效的小票 When 取车 Then 取车成功，且空余车位加1
Given 一个初始停车位为20的停车场，且空余车位为0和无效的小票 When 取车 Then 取车失败
Given 一个初始停车位为20的停车场，且空余车位为0和重复取车的小票 When 取车 Then 取车失败

Given 一个初始停车位为20的停车场，且空余车位为1 When GraduateParkingBoy 停车 Then 停车成功并打印小票，且空余车位为0
Given 一个初始停车位为20的停车场，且空余车位为0 When GraduateParkingBoy 停车 Then 停车失败
Given 一个初始停车位为20的停车场，且空余车位为0 When GraduateParkingBoy 取车 Then 取车成功，且空余车位加1
Given 一个初始停车位为20的停车场，且空余车位为0和无效的小票 When GraduateParkingBoy取车 Then 取车失败
Given 一个初始停车位为20的停车场，且空余车位为0和重复取车的小票 When GraduateParkingBoy取车 Then 取车失败
Given 两个初始停车位为20的停车场，两个个停车场空余车位都是10 When GraduateParkingBoy 停车 Then 车停在第一个停车场并打印小票，且空余车位更新
Given 两个初始停车位为20的停车场，只有第二个停车场有空余车位 When GraduateParkingBoy 停车 Then 车停在第二个停车场并打印小票，且空余车位更新
Given 两个初始停车位为20的停车场，两个个停车场空余车位都是10 When GraduateParkingBoy 从第二个停车场取车 Then 取车成功，且空余车位更新

