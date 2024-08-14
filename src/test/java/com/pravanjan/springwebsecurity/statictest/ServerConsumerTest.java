package com.pravanjan.springwebsecurity.statictest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServerConsumerTest {
    @InjectMocks
    ServerConsumer serverConsumer;
    @Mock
    ServerUtility serverUtility;

    @Test
    void ShouldReturnValidServerNameAndHost() {
        //given
         try(MockedStatic<ServerUtility> serverUtilityStatic=  mockStatic(ServerUtility.class)) {
             serverUtilityStatic.when(() -> ServerUtility.getMeta()).thenReturn(serverUtility);
              when(serverUtility.getServerName(anyString())).thenReturn("namaste");
             //then
             String response = serverConsumer.getHostAndServerName();
             Assertions.assertThat(response).isEqualTo("namaste");



         }
    }
}
