
import { useSelector,useDispatch } from "react-redux"
import { useEffect } from "react"
import { selectAllPatients,getPatientError,getPatientStatus,fetchPatients } from'./patientSlice'
//import './PatientPage.style.css'
import { Link } from 'react-router-dom'
import Backdrop from '../utility/Backdrop'
import { MdEdit,MdOutlineDelete } from "react-icons/md";
import { useState } from "react"
import ConfirmModal from '../utility/ConfirmModal'

import { deletePatient } from './patientSlice'
function PatientList(){

    
    const patients = useSelector(selectAllPatients)
    const patientStatus = useSelector(getPatientStatus)
    const error = useSelector(getPatientError)

    const dispatch = useDispatch();
    const [isModalOpen,setModalOpen] = useState(false)

   
    useEffect(()=>{
        if(patientStatus === 'idle'){
            dispatch(fetchPatients())
        }
    },[patientStatus,dispatch])

    let content;

        if(patientStatus === 'loading'){
            content = (<p>Loading....</p>)
        }
 
        if(patientStatus === 'succeed'){
            // content = patients.map( patientList => <PatientRowList
            //     id={patientList.id}
            //     patientname={patientList.patientname}
            //     address={patientList.address}
            //     description={patientList.description}
            //     gender={patientList.gender}
            //     age={patientList.age}
            //     start_date={patientList.start_date}
            //     end_date={patientList.end_date}
            // />)
            function deleteHandler(){
                setModalOpen(true);
            }
            function backdropHandler(){
                setModalOpen(false);
              }
            function cancelHandler() {
                setModalOpen(false);
            }
            function ConfirmHandler(props){
                dispatch(deletePatient(props.id)).unwrap()
                setModalOpen(false);
            }
        
            return(
                <div>
                <table className='table'>
           
                    <thead className='table'>
                      <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Address</th>
                        <th>Description</th>
                        <th>Gender</th>
                        <th>Age</th>
                        <th>Start Date</th>
                        <th>End Date</th> 
                        <th>Action</th>       
                      </tr>
                    </thead>       
         
                    <tbody>{
                   patients.map(plist => {
                    return(
                      <tr>
                        <td>{plist.id}</td>
                        <td>{plist.patientname}</td>
                        <td>{plist.address}</td>
                        <td>{plist.description}</td>
                        <td>{plist.gender}</td>
                        <td>{plist.age}</td>
                        <td>{plist.start_date}</td>
                        <td>{plist.end_date}</td>                  
                        <td>  
                              
                        <Link to={`/edit-patient/${plist.id}`}><MdEdit size='25px' /></Link> 
                           
                           <span onClick={deleteHandler}> <MdOutlineDelete size='25px' /> </span>                   
                        </td>
                        </tr> 
                    )
                   }
                   )
                    }
                 </tbody> 
           
            
           </table>
           {isModalOpen && <ConfirmModal onCancel={cancelHandler} onConfirm={ConfirmHandler}/>}
           {isModalOpen && <Backdrop onBackdrop={backdropHandler}/>}
           
      </div> 
            )
        }

        if(patientStatus === 'fail'){
            content = (<p>{error}</p>)
        }
   
   return content
   
}
export default PatientList