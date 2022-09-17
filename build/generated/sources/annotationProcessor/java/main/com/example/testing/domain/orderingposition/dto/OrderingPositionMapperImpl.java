package com.example.testing.domain.orderingposition.dto;

import com.example.testing.domain.orderingposition.OrderingPosition;
import com.example.testing.domain.product.Product;
import com.example.testing.domain.product.dto.ProductDTO;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-17T11:49:32+0200",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.2.jar, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class OrderingPositionMapperImpl implements OrderingPositionMapper {

    @Override
    public OrderingPosition fromDTO(OrderingPositionDTO dto) {
        if ( dto == null ) {
            return null;
        }

        OrderingPosition orderingPosition = new OrderingPosition();

        orderingPosition.setId( dto.getId() );
        orderingPosition.setProduct( productDTOToProduct( dto.getProduct() ) );
        orderingPosition.setAmount( dto.getAmount() );

        return orderingPosition;
    }

    @Override
    public List<OrderingPosition> fromDTOs(List<OrderingPositionDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<OrderingPosition> list = new ArrayList<OrderingPosition>( dtos.size() );
        for ( OrderingPositionDTO orderingPositionDTO : dtos ) {
            list.add( fromDTO( orderingPositionDTO ) );
        }

        return list;
    }

    @Override
    public Set<OrderingPosition> fromDTOs(Set<OrderingPositionDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        Set<OrderingPosition> set = new LinkedHashSet<OrderingPosition>( Math.max( (int) ( dtos.size() / .75f ) + 1, 16 ) );
        for ( OrderingPositionDTO orderingPositionDTO : dtos ) {
            set.add( fromDTO( orderingPositionDTO ) );
        }

        return set;
    }

    @Override
    public OrderingPositionDTO toDTO(OrderingPosition BO) {
        if ( BO == null ) {
            return null;
        }

        OrderingPositionDTO orderingPositionDTO = new OrderingPositionDTO();

        orderingPositionDTO.setId( BO.getId() );
        orderingPositionDTO.setProduct( productToProductDTO( BO.getProduct() ) );
        orderingPositionDTO.setAmount( BO.getAmount() );

        return orderingPositionDTO;
    }

    @Override
    public List<OrderingPositionDTO> toDTOs(List<OrderingPosition> BOs) {
        if ( BOs == null ) {
            return null;
        }

        List<OrderingPositionDTO> list = new ArrayList<OrderingPositionDTO>( BOs.size() );
        for ( OrderingPosition orderingPosition : BOs ) {
            list.add( toDTO( orderingPosition ) );
        }

        return list;
    }

    @Override
    public Set<OrderingPositionDTO> toDTOs(Set<OrderingPosition> BOs) {
        if ( BOs == null ) {
            return null;
        }

        Set<OrderingPositionDTO> set = new LinkedHashSet<OrderingPositionDTO>( Math.max( (int) ( BOs.size() / .75f ) + 1, 16 ) );
        for ( OrderingPosition orderingPosition : BOs ) {
            set.add( toDTO( orderingPosition ) );
        }

        return set;
    }

    protected Product productDTOToProduct(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productDTO.getId() );
        product.setName( productDTO.getName() );

        return product;
    }

    protected ProductDTO productToProductDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId( product.getId() );
        productDTO.setName( product.getName() );

        return productDTO;
    }
}
