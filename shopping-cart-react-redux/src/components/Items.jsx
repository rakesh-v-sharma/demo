import * as React from 'react'
import {DataGrid} from '@mui/x-data-grid';
import {
  useDispatch,
useSelector
} from 'react-redux';
import { fetchItems } from '../actions/itemPageActions';
export const Items = () => {
  const dispatch = useDispatch();
  const items = useSelector(state => state.itemsSlice.data);
  const dataStatus = useSelector(state => state.itemsSlice.status);
    React.useEffect(() => {
      dispatch(fetchItems())

    });
  const row = [
    {id: 1, name: "Test Name", description: "Test description", price: "100"},
    {id: 2, name: "Test Name", description: "Test description", price: "100"},
    {id: 3, name: "Test Name", description: "Test description", price: "100"}
  ]
  const cols = [
    {field: "id", headerName: "ID", width: 200 },
    { field: "name", headerName: "Name", width: 200 },
    { field: "description", headerName: "Description", width: 200 },
    { field: "price", headerName: "Price", width: 200 }
  ]
  console.log(items);
  console.log(dataStatus);

  return(
    <div style={{height: '100Vh'}}>
      <DataGrid rows={row} columns={cols}/>
    </div>
  )
}