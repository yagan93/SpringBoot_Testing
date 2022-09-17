package com.example.testing.domain.ordering.dto;

import com.example.testing.domain.ordering.Ordering;
import com.example.testing.domain.orderingposition.OrderingPosition;
import com.example.testing.domain.orderingposition.dto.OrderingPositionDTO;
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
public class OrderingMapperImpl implements OrderingMapper {

    @Override
    public Ordering fromDTO(OrderingDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Ordering ordering = new Ordering();

        ordering.setId( dto.getId() );
        ordering.setOrderingPositions( orderingPositionDTOSetToOrderingPositionSet( dto.getOrderingPositions() ) );

        return ordering;
    }

    @Override
    public List<Ordering> fromDTOs(List<OrderingDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Ordering> list = new ArrayList<Ordering>( dtos.size() );
        for ( OrderingDTO orderingDTO : dtos ) {
            list.add( fromDTO( orderingDTO ) );
        }

        return list;
    }

    @Override
    public Set<Ordering> fromDTOs(Set<OrderingDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        Set<Ordering> set = new LinkedHashSet<Ordering>( Math.max( (int) ( dtos.size() / .75f ) + 1, 16 ) );
        for ( OrderingDTO orderingDTO : dtos ) {
            set.add( fromDTO( orderingDTO ) );
        }

        return set;
    }

    @Override
    public OrderingDTO toDTO(Ordering BO) {
        if ( BO == null ) {
            return null;
        }

        OrderingDTO orderingDTO = new OrderingDTO();

        orderingDTO.setId( BO.getId() );
        orderingDTO.setOrderingPositions( orderingPositionSetToOrderingPositionDTOSet( BO.getOrderingPositions() ) );

        return orderingDTO;
    }

    @Override
    public List<OrderingDTO> toDTOs(List<Ordering> BOs) {
        if ( BOs == null ) {
            return null;
        }

        List<OrderingDTO> list = new ArrayList<OrderingDTO>( BOs.size() );
        for ( Ordering ordering : BOs ) {
            list.add( toDTO( ordering ) );
        }

        return list;
    }

    @Override
    public Set<OrderingDTO> toDTOs(Set<Ordering> BOs) {
        if ( BOs == null ) {
            return null;
        }

        Set<OrderingDTO> set = new LinkedHashSet<OrderingDTO>( Math.max( (int) ( BOs.size() / .75f ) + 1, 16 ) );
        for ( Ordering ordering : BOs ) {
            set.add( toDTO( ordering ) );
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

    protected OrderingPosition orderingPositionDTOToOrderingPosition(OrderingPositionDTO orderingPositionDTO) {
        if ( orderingPositionDTO == null ) {
            return null;
        }

        OrderingPosition orderingPosition = new OrderingPosition();

        orderingPosition.setId( orderingPositionDTO.getId() );
        orderingPosition.setProduct( productDTOToProduct( orderingPositionDTO.getProduct() ) );
        orderingPosition.setAmount( orderingPositionDTO.getAmount() );

        return orderingPosition;
    }

    protected Set<OrderingPosition> orderingPositionDTOSetToOrderingPositionSet(Set<OrderingPositionDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<OrderingPosition> set1 = new LinkedHashSet<OrderingPosition>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( OrderingPositionDTO orderingPositionDTO : set ) {
            set1.add( orderingPositionDTOToOrderingPosition( orderingPositionDTO ) );
        }

        return set1;
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

    protected OrderingPositionDTO orderingPositionToOrderingPositionDTO(OrderingPosition orderingPosition) {
        if ( orderingPosition == null ) {
            return null;
        }

        OrderingPositionDTO orderingPositionDTO = new OrderingPositionDTO();

        orderingPositionDTO.setId( orderingPosition.getId() );
        orderingPositionDTO.setProduct( productToProductDTO( orderingPosition.getProduct() ) );
        orderingPositionDTO.setAmount( orderingPosition.getAmount() );

        return orderingPositionDTO;
    }

    protected Set<OrderingPositionDTO> orderingPositionSetToOrderingPositionDTOSet(Set<OrderingPosition> set) {
        if ( set == null ) {
            return null;
        }

        Set<OrderingPositionDTO> set1 = new LinkedHashSet<OrderingPositionDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( OrderingPosition orderingPosition : set ) {
            set1.add( orderingPositionToOrderingPositionDTO( orderingPosition ) );
        }

        return set1;
    }
}
