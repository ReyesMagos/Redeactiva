package co.gov.coldeportes.redeactiva.redapptiva.controladores;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import co.gov.coldeportes.redeactiva.redapptiva.R;
import co.gov.coldeportes.redeactiva.redapptiva.activities.ProjectSearchActivity;
import co.gov.coldeportes.redeactiva.redapptiva.entity.factory.ProjectFactory;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.Projects;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.adaptadores.ProjectCustomAdapter;

public class ProjectsController extends AbstractController {

	private ProjectFactory projectFactory;
	private final int LIMIT_MAX = 10;
	public static List<Projects> proListAux;
	Activity activity;

	public TextView texViewTitulo;
	private TextView textViewTipoEntidad;
	private TextView textViewDepartamento;
	private TextView textViewContacto;
	private TextView textViewDireccion;
	private ImageView imageViewContact;
	Projects proyectoAux;

	public ProjectsController(Activity activity) {
		super(activity);

	}

	public void showProjectsListView() {
		ProjectSearchActivity p = (ProjectSearchActivity) getActivity();
		ProjectCustomAdapter projectCustomAdapter = new ProjectCustomAdapter(
				getActivity(), ProjectFactory.getInstance().getProListAux());
		p.getListViewProjects().setAdapter(projectCustomAdapter);
		p.getListViewProjects().setOnItemClickListener(
				new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> adapter, View view,
							int position, long arg3) {
						proyectoAux = ProjectFactory.getInstance()
								.getProjectsList().get(position);
						AlertDialog.Builder builder = new AlertDialog.Builder(
								getActivity());
						LayoutInflater inflater = LayoutInflater
								.from(getActivity());

						View dialogView = inflater.inflate(
								R.layout.info_project_activity, null);
						builder.setView(dialogView);

						builder.setTitle("Información");
						builder.setIcon(R.drawable.ic_launcher);
						final TextView texViewTitulo = (TextView) dialogView
								.findViewById(R.id.txt_titulo_Proyecto);
						final TextView textViewTipoEntidad = (TextView) dialogView
								.findViewById(R.id.txt_tipo_entidad);
						final TextView textViewDepartamento = (TextView) dialogView
								.findViewById(R.id.txt_departamento);
						final TextView textViewContacto = (TextView) dialogView
								.findViewById(R.id.txt_contacto);
						final TextView textViewDireccion = (TextView) dialogView
								.findViewById(R.id.txt_direccion);
						final TextView textViewPagweb = (TextView) dialogView
								.findViewById(R.id.txt_link_web);
						final ImageView imageViewContact = (ImageView) dialogView
								.findViewById(R.id.image_view_contactar);

						texViewTitulo.setText(proyectoAux.getTipo());
						textViewTipoEntidad.setText(proyectoAux
								.getTipoEntidad());
						textViewDepartamento.setText(proyectoAux
								.getCodigoDepartamento());
						textViewContacto.setText(proyectoAux
								.getPersonaContacto());
						textViewDireccion.setText(proyectoAux
								.getDireccionMunicipio());
						textViewPagweb.setText(proyectoAux.getPaginaWeb());
						imageViewContact
								.setOnClickListener(new View.OnClickListener() {

									@Override
									public void onClick(View v) {
										enviarCorreo();

									}
								});
						builder.setPositiveButton("Aceptar",
								new OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub

									}
								});
						builder.show();
					}

				});
	}

	public void showProgressDialog() {
		ProgressDialog progressDialog = new ProgressDialog(this.getActivity());
	}

	public void filtersForProject() {
		AlertDialog.Builder alertBuilder = new AlertDialog.Builder(
				getActivity());

		alertBuilder.setIcon(R.drawable.ic_launcher);
		alertBuilder.setTitle("Selecciono Filtro");

		final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
				getActivity(), android.R.layout.select_dialog_singlechoice);
		arrayAdapter.add("Deporte Social Comunitario");
		arrayAdapter.add("Recreativo");
		arrayAdapter.add("Por mi departamento");
		arrayAdapter.add("Por mi municipio");
		arrayAdapter.add("Tipo de Entidad");

		alertBuilder.setAdapter(arrayAdapter, new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int option) {
				if (option == 0) {
					ProjectFactory.filterOption = 0;
					ProjectSearchActivity p = (ProjectSearchActivity) getActivity();
					ProjectCustomAdapter projectCustomAdapter = new ProjectCustomAdapter(
							getActivity(), ProjectFactory.getInstance()
									.filterProjects(0));
					p.getListViewProjects().setAdapter(projectCustomAdapter);
					p.getListViewProjects().setOnItemClickListener(
							new OnItemClickListener() {

								@Override
								public void onItemClick(AdapterView<?> adapter,
										View view, int position, long arg3) {
									Projects proyectoAux = ProjectFactory
											.getInstance().filterProjects(0)
											.get(position);
									AlertDialog.Builder builder = new AlertDialog.Builder(
											getActivity());
									LayoutInflater inflater = LayoutInflater
											.from(getActivity());

									View dialogView = inflater.inflate(
											R.layout.info_project_activity,
											null);
									builder.setView(dialogView);

									builder.setTitle("Información");
									builder.setIcon(R.drawable.ic_launcher);
									// createComponentsInfo();
									final TextView texViewTitulo = (TextView) dialogView
											.findViewById(R.id.txt_titulo_Proyecto);
									final TextView textViewTipoEntidad = (TextView) dialogView
											.findViewById(R.id.txt_tipo_entidad);
									final TextView textViewDepartamento = (TextView) dialogView
											.findViewById(R.id.txt_departamento);
									final TextView textViewContacto = (TextView) dialogView
											.findViewById(R.id.txt_contacto);
									final TextView textViewDireccion = (TextView) dialogView
											.findViewById(R.id.txt_direccion);
									final ImageView imageViewContact = (ImageView) dialogView
											.findViewById(R.id.image_view_contactar);
									texViewTitulo.setText(proyectoAux.getTipo());
									textViewTipoEntidad.setText(proyectoAux
											.getTipoEntidad());

									String dpto;
									switch (Integer.parseInt(proyectoAux
											.getCodigoDepartamento())) {
									case 86:
										dpto = "Putumayo";
										break;
									case 85:
										dpto = "Casanare";
										break;
									case 47:
										dpto = "Magdalena";
										break;
									case 25:
										dpto = "Cundinamarca";
										break;
									case 91:
										dpto = "Amazonas";
										break;
									case 05:
										dpto = "Antioquia";
										break;
									case 81:
										dpto = "Arauca";
										break;
									case 8:
										dpto = "Atlantico";
										break;
									case 11:
										dpto = "Bogota D.C";
										break;
									default:
										dpto = "Norte de Santander";
										break;
									}
									textViewDepartamento.setText(dpto);
									textViewContacto.setText(proyectoAux
											.getPersonaContacto());
									textViewDireccion.setText(proyectoAux
											.getDireccionMunicipio());

									builder.show();
								}

							});

				} else if (option == 1) {
					ProjectFactory.filterOption = 1;
					ProjectSearchActivity p = (ProjectSearchActivity) getActivity();
					ProjectCustomAdapter projectCustomAdapter = new ProjectCustomAdapter(
							getActivity(), ProjectFactory.getInstance()
									.filterProjects(1));
					p.getListViewProjects().setAdapter(projectCustomAdapter);
				}

			}
		});
		alertBuilder.setPositiveButton("Aceptar", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub

			}
		});
		alertBuilder.show();

	}

	public void createComponentsInfo() {
		this.texViewTitulo = (TextView) getActivity().findViewById(
				R.id.txt_titulo_Proyecto);
		this.textViewTipoEntidad = (TextView) getActivity().findViewById(
				R.id.txt_tipo_entidad);
		this.textViewDepartamento = (TextView) getActivity().findViewById(
				R.id.txt_departamento);
		this.textViewContacto = (TextView) getActivity().findViewById(
				R.id.txt_contacto);
		this.textViewDireccion = (TextView) getActivity().findViewById(
				R.id.txt_direccion);
		this.imageViewContact = (ImageView) getActivity().findViewById(
				R.id.image_view_contactar);
	}

	public void enviarCorreo() {
		Intent i = new Intent(Intent.ACTION_SEND);
		i.setType("message/rfc822");
		i.putExtra(Intent.EXTRA_EMAIL, new String[] { proyectoAux.getEmail() });
		i.putExtra(Intent.EXTRA_SUBJECT,
				"Persona Interesada en mas información");
		try {
			getActivity().startActivity(
					Intent.createChooser(i, "Enviando Email..."));
			getActivity().finish();
		} catch (android.content.ActivityNotFoundException ex) {

		}
	}

}
