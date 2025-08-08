package com.augustogp.nutrifit.food_item.adapter.grpc.server;

import com.augustogp.nutrifit.food_item.dto.FoodItemResponse;
import com.augustogp.nutrifit.food_item.mapper.FoodItemGrpcMapper;
import com.augustogp.nutrifit.food_item.service.FoodItemService;
import com.nutrifit.fooditem.v1.FoodItemServiceGrpc;
import com.nutrifit.fooditem.v1.GetFoodItemByNameRequest;
import com.nutrifit.fooditem.v1.GetFoodItemResponse;
import com.nutrifit.foodlog.v1.GrpcFoodLogResponse;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
@Slf4j
public class FoodItemGrpcService extends FoodItemServiceGrpc.FoodItemServiceImplBase {

    private final FoodItemService foodItemService;

    public void getFoodItemByName(GetFoodItemByNameRequest getFoodItemByNameRequest, StreamObserver<GetFoodItemResponse> responseObserver) {

        log.info("getFoodItemByName request:{}", getFoodItemByNameRequest);

        FoodItemResponse foodItemResponse = this.foodItemService.findByName(getFoodItemByNameRequest.getName());

        GetFoodItemResponse grpcResponse = FoodItemGrpcMapper.toGetFoodItemResponse(foodItemResponse);

        responseObserver.onNext(grpcResponse);
        responseObserver.onCompleted();
    }
}
